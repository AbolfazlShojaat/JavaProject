package ir.pt.library.dao.repoImpl;

import ir.pt.library.dao.LibraryRepo;
import ir.pt.library.entity.LibraryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LibraryRepoImpl implements LibraryRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public LibraryEntity updateReceive(LibraryEntity entity) {
        int i = em.createQuery("update LibraryEntity l " + " set l.existNum= : existNum " +
                " where l.id= :code")
                .setParameter("code", entity.getId())
                .setParameter("existNum", entity.getExistNum() + 1)
                .executeUpdate();

        return em.find(LibraryEntity.class, entity.getId());
    }

    @Override
    public LibraryEntity updateReturn(LibraryEntity entity) {
        int i = em.createQuery("update LibraryEntity l " + " set l.existNum= : existNum " +
                " where l.id= :code")
                .setParameter("code", entity.getId())
                .setParameter("existNum", entity.getExistNum() - 1)
                .executeUpdate();

        return em.find(LibraryEntity.class, entity.getId());
    }

    @Override
    public List<LibraryEntity> isBorrowAble() {
        List<LibraryEntity> entities = (List<LibraryEntity>) em.createQuery("from LibraryEntity l" + " " +
                "where l.isBorrowAble= :true")
                .setParameter("true", true)
                .getResultList();
        return entities;
    }

    @Override
    public List<LibraryEntity> getAllLibrary() {
        return em.createQuery("from LibraryEntity l").getResultList();
    }

    @Override
    public Integer checkExistNum(Integer id) {
        int i = (int) em.createQuery("select l.existNum from LibraryEntity l" + " " + "where l.id=: id")
                .setParameter("id", id)
                .getSingleResult();
        return i;
    }
}