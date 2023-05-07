
public abstract class Metal {
    public abstract int getEndurance();
}

class Copper extends Metal {
    @Override
    public int getEndurance() {
        return 20;
    }
}

class Iron extends Metal {
    @Override
    public int getEndurance() {
        return 30;
    }
}

class Plastic {
}

class Sword<T extends Metal> {

    private final T metal;

    public Sword(T metal) {
        this.metal = metal;
    }

    public boolean checkEndurance() {
        return metal.getEndurance() > 49;
    }

}

class Test {
    public static void main(String[] args) {

        Sword<Steel> steelSword = new Sword<>(new Steel());


        boolean isStrong = steelSword.checkEndurance();
        if (isStrong){
            System.out.println("Меч из стали прошел проверку прочности");
        }
        else{
            System.out.println("Меч из стали не прошел проверку прочности");
        }

    }
}