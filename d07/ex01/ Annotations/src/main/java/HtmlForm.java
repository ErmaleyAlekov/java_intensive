import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface HtmlForm
{
    String fileName() default  "";
    String action() default  "";
    String method() default  "";
}
