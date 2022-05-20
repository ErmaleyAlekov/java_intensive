import com.google.auto.service.AutoService;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.*;
import java.util.List;
import java.util.Set;

@SupportedAnnotationTypes({"HtmlForm", "HtmlInput"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService({HtmlForm.class,HtmlInput.class})
public class HtmlProcessor extends AbstractProcessor
{
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
    {
        for (Element userForm : roundEnv.getElementsAnnotatedWith(HtmlForm.class))
        {
            HtmlForm form = userForm.getAnnotation(HtmlForm.class);
            String str = "<form action = \"" + form.action() + "\" method = \"" + form.method() + "\">\n";
            List<? extends Element> Elements = userForm.getEnclosedElements();
            for (Element field : roundEnv.getElementsAnnotatedWith(HtmlInput.class))
            {
                if (!Elements.contains(field)) {
                    continue;
                }
                HtmlInput InForm = field.getAnnotation(HtmlInput.class);
                str += "\t<input type = " + InForm.type() + "\" name = \"" +
                        InForm.name() + "\" placeholder = \"" + InForm.placeholder() + "\">\n";
            }
            str += "\t<input type = \"submit\" value = \"Send\">\n</form>";
            try (BufferedWriter Write = new BufferedWriter(new FileWriter("target/classes/" + form.fileName())))
            {
                Write.write(str);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }
}
