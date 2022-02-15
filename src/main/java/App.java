import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        // В классе App, по аналогии, вызовите еще раз бин HelloWorld
        HelloWorld beanSecondReauest =
                (HelloWorld) applicationContext.getBean("helloworld");
        // затем 2 раза вызовите бин cat
        Cat catFirstRequest = (Cat) applicationContext.getBean("cat");
        Cat catSecondRequest = (Cat) applicationContext.getBean("cat");

        System.out.println(bean.getMessage()); // исходник

        //Сравните 2 пары бинов по ссылке и выведите результат в консоль.
        System.out.println(java.util.Objects.equals(bean, beanSecondReauest));
        System.out.println(java.util.Objects.equals(catFirstRequest, catSecondRequest));

    }
}