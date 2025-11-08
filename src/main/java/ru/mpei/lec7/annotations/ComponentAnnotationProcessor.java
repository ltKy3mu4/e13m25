package ru.mpei.lec7.annotations;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import ru.mpei.lec7.impl.Sender;
import ru.mpei.lec7.impl.SenderContextHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@Slf4j
public class ComponentAnnotationProcessor {

    public static void bindAllSenders(){
        Reflections reflections = new Reflections(Sender.class);

        Set<Class<?>> cls = reflections.getTypesAnnotatedWith(Component.class);
        for (var c: cls){
            try {
                Constructor<?> cons = c.getDeclaredConstructor();
                Object impl = cons.newInstance();
                if (impl instanceof Sender){
                    Component compAnno = c.getAnnotation(Component.class);
                    for (int i =0; i < compAnno.count(); i++){
                        SenderContextHolder.senders.add((Sender) impl);
                    }
                    log.info("Bound sender: " + c.getName());
                } else {
                    log.warn("Can't bind sender: " + c.getName());
                }

            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

}
