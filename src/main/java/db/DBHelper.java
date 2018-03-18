package db;

import models.Day;
import models.Food;
import models.Meal;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void save(Object object) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void saveOrUpdate(Object object) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> T find(Class classType, int id){
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria criteria = session.createCriteria(classType);
        criteria.add(Restrictions.idEq(id));
        result = getUnique(criteria);
        return result;
    }

    public static <T> List<T> getAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria criteria = session.createCriteria(classType);
        results = getList(criteria);
        return results;
    }

    private static <T> List<T> getList(Criteria criteria){
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = criteria.list();
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    private static <T> T getUnique(Criteria criteria){
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T)criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static List<Meal> getAllMealsForDay(Day day){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Meal> results = null;
        Criteria cr = session.createCriteria(Meal.class);
        cr.add(Restrictions.eq("day", day));
        results = getList(cr);
        return results;
    }

    public static List<Meal> getAllMealsForDate(GregorianCalendar date){
        session = HibernateUtil.getSessionFactory().openSession();

        List<Meal> results = new ArrayList<Meal>();
        List<Meal> allMeals = getAll(Meal.class);

        for (Meal meal : allMeals) {
            if (meal.getDay().getDayDate().equals(date)) {
                results.add(meal);
            }
        }
        return results;
    }

    public static void addFoodToMeal(Food food, Meal meal) {
        meal.addFood(food);
        saveOrUpdate(meal);
    }

    public static Double dailyCalorieTotal(Day day) {
        session = HibernateUtil.getSessionFactory().openSession();

        double dayCalories = 0.00;

        List<Meal> results = new ArrayList<Meal>();
        List<Meal> allMeals = getAll(Meal.class);

        for (Meal meal : allMeals) {
            dayCalories += meal.calculateCalorieTotal();
        }

        return dayCalories;
    }

}
