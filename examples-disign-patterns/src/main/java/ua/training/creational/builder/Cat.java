package ua.training.creational.builder;

public class Cat {
    private String name;
    private int age;
    private boolean isStriped;

    private Cat(CatBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.isStriped = builder.isStriped;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isStriped() {
        return isStriped;
    }

    public static class CatBuilder {
        private String name;
        private int age;
        private boolean isStriped;

        public CatBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public CatBuilder setStriped(boolean striped) {
            isStriped = striped;
            return this;
        }

        public Cat build() {
            return new Cat(this);
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isStriped=" + isStriped +
                '}';
    }
}
