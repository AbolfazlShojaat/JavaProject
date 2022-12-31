package ir.pt.library.dao.repoImpl;

import ir.pt.library.dao.BorrowRepo;
import ir.pt.library.entity.BorrowEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BorrowRepoImpl implements BorrowRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BorrowEntity create(BorrowEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public List<BorrowEntity> getAllBorrowPerson(Integer id) {
        return entityManager.createQuery("from BorrowEntity b" + " " +
                "where b.person.id =: id")
                .setParameter("id", id)
                .getResultList();
    }

    @Transactional
    @Override
    public List<BorrowEntity> getAllBorrow() {
        return entityManager.createQuery("from BorrowEntity b").getResultList();
    }

    @Override
    public BorrowEntity get(Integer id) {
        BorrowEntity entity = (BorrowEntity)
                entityManager.createQuery("from BorrowEntity b" + " " + "where b.id=: id")
                        .setParameter("id", id)
                        .getSingleResult();
        return entity;
    }

    @Override
    public Boolean remove(BorrowEntity entity) {
        int i = entityManager.createQuery("delete from BorrowEntity b " +
                " where b.id= :code")
                .setParameter("code", entity.getId())
                .executeUpdate();
        return true;
    }
}
