package ua.training.part2;

public class CompilerBehavior {
//        // пугаем Exception
//        public static void main(String[] args) throws Exception {
//            Throwable t = new Exception(); // и лететь будет Exception
//            throw t; // но тут ошибка компиляции
//        }
//    }
//
//>>
//    COMPILATION ERROR:
//    unhandled exception:java.lang.Throwable


//    public static void f0(Throwable t) throws Exception {
//        throw t; //unhandled exception:java.lang.Throwable
//    }

//    public static void f1(Object ref) {
//        char c = ref.charAt(0);
//    }


    // пугаем Exception
//    public static void main(String[] args) throws Exception {
//        try {
//            Throwable t = new Exception(); // и лететь будет Exception
//            throw t; // но тут ошибка компиляции
//        } catch (Exception e) {
//            System.out.println("Перехвачено!");
//        }
//    }
//>> COMPILATION ERROR: unhandled exception: java.lang.Throwable

    // ТЕПЕРЬ пугаем Throwable
    public static void main(String[] args) throws Throwable {
        try {
            Throwable t = new Exception(); // а лететь будет Exception
            throw t;
        } catch (Exception e) { // и мы перехватим Exception
            System.out.println("Перехвачено!");
        }
    }


//>> Перехвачено!
}
