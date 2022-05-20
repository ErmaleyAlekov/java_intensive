import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface HtmlInput
{
    String type() default  "";
    String name() default  "";
    String placeholder() default  "";
}