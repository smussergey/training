package ua.training.part1;

public class MultyLevelTryCatchBlocks2 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                if (true) {
                    throw new RuntimeException();
                }
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // ЗАХОДИМ - есть исключение
            } finally {
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // заходим - выполнение УЖЕ в норме
        } catch (Exception e) {
            System.err.print(" 6");     // не заходим - нет исключения, УЖЕ перехвачено
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // заходим - выполнение УЖЕ в норме
    }
}
