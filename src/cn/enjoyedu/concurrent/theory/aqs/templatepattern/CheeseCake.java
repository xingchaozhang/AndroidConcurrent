package cn.enjoyedu.concurrent.theory.aqs.templatepattern;

/**
 * 类说明：芝士蛋糕
 */
public class CheeseCake  extends AbstractCake {

    @Override
    protected void shape() {
        System.out.println("芝士蛋糕造型");
    }

    @Override
    protected void apply() {
        System.out.println("芝士蛋糕涂抹 芝士");
    }

    @Override
    protected void brake() {
        System.out.println("芝士蛋糕烘焙  5  min");
    }
}
