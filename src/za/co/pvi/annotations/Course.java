package za.co.pvi.annotations;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Course {
	public float amount() default 1000.0F;
	public String name() default "Java Programming";
	
}
