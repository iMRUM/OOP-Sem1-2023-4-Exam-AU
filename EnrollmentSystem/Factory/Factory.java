package Factory;

import Observer.AbstractUser;

import java.util.List;
import java.util.Map;

public class Factory {
    private static Map<String, IProduct> productMap;
    private static List<AbstractUser> userList;

    public static void setUserList(List<AbstractUser> usersList) {
        userList = usersList;
    }

    public static void setProductMap(Map<String, IProduct> productsMap) {
        productMap = productsMap;
    }

    public static AbstractCourse getCourse(String name, String id, int type, ConcreteProfessor concreteProfessor) {
        if (!productMap.containsKey(id)) {
            switch (type) {
                case 1:
                    productMap.put(id, new MandatoryCourse(name, id, concreteProfessor));
                    break;
                case 2:
                    productMap.put(id, new ElectiveCourse(name, id, concreteProfessor));
                    break;
                case 3:
                    productMap.put(id, new SeminarCourse(name, id, concreteProfessor));
                    break;
            }
        }
        return (AbstractCourse) productMap.get(id);
    }

    public static AbstractUser getUser(String name, String id, int type) {
        if (!productMap.containsKey(id)) {
            if (userList.size() >= 100) {
                System.out.println("ERROR: SYSTEM IS AT FULL CAPACITY");
            } else {
                switch (type) {
                    case 1:
                        productMap.put(id, new ConcreteStudent(name, id));
                        userList.add((AbstractUser) productMap.get(id));
                        break;
                    case 2:
                        productMap.put(id, new ConcreteProfessor(name, id));
                        userList.add((AbstractUser) productMap.get(id));
                        break;
                    case 3:
                        productMap.put(id, new ConcreteLecturer(name, id));
                        userList.add((AbstractUser) productMap.get(id));
                        break;
                }
            }
        }
        return (AbstractUser) productMap.get(id);
    }

    public static void removeProduct(String id){
        productMap.remove(id);
    }
}
