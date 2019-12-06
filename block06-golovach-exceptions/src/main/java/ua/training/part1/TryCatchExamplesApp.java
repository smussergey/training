package ua.training.part1;

public class TryCatchExamplesApp {
//    public static void main(String[] args) {
//        try {
//            System.err.print(" 0");
//            if (true) {
//                throw new RuntimeException();
//            }
//            System.err.print(" 1");
//        } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
//            System.err.print(" 2");
//        }
//        System.err.println(" 3");
//    }
//}         >> 0 2 3

//    public static void main(String[] args) {
//    try {
//        throw new RuntimeException();
//    } catch (Exception e) {
//        if (e instanceof RuntimeException) {
//            RuntimeException re = (RuntimeException) e;
//            System.err.print("Это RuntimeException на самом деле!!!");
//        } else {
//            System.err.print("В каком смысле не RuntimeException???");
//        }
//    }
//}
//}         >> Это RuntimeException на самом деле!!!

//    public static void main(String[] args) throws Exception { // пока игнорируйте 'throws'
//        try {
//            System.err.print(" 0");
//            if (true) {
//                throw new Exception();
//            }
//            System.err.print(" 1");
//        } catch (RuntimeException e) {
//            System.err.print(" 2");
//        }
//        System.err.print(" 3");
//    }
//}       //>> 0
//>> RUNTIME EXCEPTION: Exception in thread "main" java.lang.Exception

//    public static void main(String[] args) {
//        try {
//            System.err.print(" 0");
//            if (true) {throw new Error();}
//            System.err.print(" 1");
//        } catch (Exception e) {
//            System.err.print(" 2");
//        }
//        System.err.print(" 3");
//    }
//}
//
//>> 0
//        >> RUNTIME EXCEPTION: Exception in thread "main" java.lang.Error

//    public static void main(String[] args) {
//        try {
//            System.err.print(" 0");
//            if (true) {throw new RuntimeException();}
//            System.err.print(" 1");
//        } catch (RuntimeException e) { // перехватили RuntimeException
//            System.err.print(" 2");
//            if (true) {throw e;}       // и бросили ВТОРОЙ раз ЕГО ЖЕ
//        }
//        System.err.println(" 3");      // пропускаем - опять летит RuntimeException
//    }
//}

//>> 0 2
//        >> RUNTIME EXCEPTION: Exception in thread "main" java.lang.RuntimeException


//                  !!!!
//    public static void main(String[] args) {
//        try {
//            System.err.print(" 0");
//            if (true) {throw new RuntimeException();}
//            System.err.print(" 1");
//        } catch (RuntimeException e) {     // перехватили RuntimeException
//            System.err.print(" 2");
//            if (true) {throw new Error();} // и бросили новый Error
//        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
//            System.err.print(" 3");
//        }
//        System.err.println(" 4");
//    }
//}

//>> 0 2
//        >> RUNTIME EXCEPTION: Exception in thread "main" java.lang.Error


        public static void main(String[] args) {
            try {
                System.err.print(" 0");
                if (true) {throw new RuntimeException();}
                System.err.print(" 1");
            } catch (RuntimeException e) { // перехватили RuntimeException
                System.err.print(" 2.1");
                try {
                    System.err.print(" 2.2");
                    if (true) {throw new Error();} // и бросили новый Error
                    System.err.print(" 2.3");
                } catch (Throwable t) {            // перехватили Error
                    System.err.print(" 2.4");
                }
                System.err.print(" 2.5");
            } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
                System.err.print(" 3");
            }
            System.err.println(" 4");
        }
    }

//>> 0 2.1 2.2 2.4 2.5 4