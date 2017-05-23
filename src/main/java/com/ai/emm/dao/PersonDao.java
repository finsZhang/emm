package com.ai.emm.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.ai.emm.domain.Person;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/10/19
 * Time: 14:59
 * Email:zhangfz3@asiainfo.com
 *CrudRepository,PagingAndSortingRepository,JpaRepository
 * SimpleJpaRepository,QueryDslPredicateExecutor
 */
public interface  PersonDao extends Repository<Person,Integer> {
    List<Person> findByName(String name);
    @Query("SELECT P FROM Person P WHERE P.id =(SELECT max(P2.id) FROM Person P2)")
    Person getMaxIdPerson();
    @Query("SELECT P FROM #{#entityName} P where P.name=?1 and P.age=?2")
    Person findByNameAndAge(String name,int age);
    @Query("SELECT P FROM Person P where P.name=:name and P.age=:age")
    Person findByNameAndAgeAnnotation(@Param("name")String name,@Param("age")int age);
    @Query(value="SELECT count(id) FROM person",nativeQuery = true)
    long findByNameAndAgeAnnotation1();
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value="update Person p set p.name=?1 where p.id=?2")
    void updatePersonNameById(String name,Integer id);
}
