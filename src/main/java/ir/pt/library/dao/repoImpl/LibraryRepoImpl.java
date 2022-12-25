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
    public LibraryEntity get(Integer id) {
        LibraryEntity library = (LibraryEntity) em.createQuery("from  LibraryEntity l where l.book.id = :id")
                .setParameter("id", id).getSingleResult();
        return library;
    }

    @Override
    public LibraryEntity create(LibraryEntity entity) {
        em.persist(entity);
        return entity;
    }

    //دریافت کتاب
    @Override
    public LibraryEntity updateReceive(Integer id) throws Exception {
        LibraryEntity entity = get(id);
        int exist = entity.getExistNum() - 1;
        int i = em.createQuery("update LibraryEntity l " + " set l.existNum= : existNum " +
                " where l.book.id= :id")
                .setParameter("id", id)
                .setParameter("existNum", exist)
                .executeUpdate();
        entity.setExistNum(exist);
        return entity;
    }

    //قرض دادن کتاب
    @Override
    public LibraryEntity updateReturn(Integer id) throws Exception {
        LibraryEntity entity = get(id);
        if (entity.getExistNum() > 0) {
            int exist = entity.getExistNum() + 1;
            int i = em.createQuery("update LibraryEntity l " + " set l.existNum= : existNum " +
                    " where l.book.id= :id")
                    .setParameter("id", id)
                    .setParameter("existNum", exist)
                    .executeUpdate();
            entity.setExistNum(exist);
            return entity;
        } else
            throw new Exception("This book is not available");
    }

//    @Override
//    public LibraryEntity updateReturn(Integer id) throws Exception {
//        LibraryEntity entity = get(id);
//        if (entity.getExistNum() > 0) {
//            int i = em.createQuery("update LibraryEntity l " + " set l.existNum= : existNum " +
//                    " where l.book.id= :id")
//                    .setParameter("id", id)
//                    .setParameter("existNum", entity.getExistNum() - 1)
//                    .executeUpdate();
//            return em.find(LibraryEntity.class, entity.getId());
//        }
//        else
//            throw new Exception("This book is not available");
//    }

    @Override
    public List<LibraryEntity> isBorrowAble() {
        List<LibraryEntity> entities = (List<LibraryEntity>) em.createQuery("from LibraryEntity l" + " " +
                "where l.isBorrowAble= :true")
                .setParameter("true", true)
                .getResultList();
        return entities;
    }

    @Override
    public List getAllLibrary() {
        return em.createQuery("from LibraryEntity l")
        .getResultList();
    }

    @Override
    public Integer checkExistNum(Integer id) {
        int i = (int) em.createQuery("select l.existNum from LibraryEntity l" + " " + "where l.book.id=: id")
                .setParameter("id", id)
                .getSingleResult();
        return i;
    }
}
