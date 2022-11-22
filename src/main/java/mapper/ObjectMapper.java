package mapper;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ObjectMapper {

    public static String writeToString(Object object) throws IllegalAccessException {
        // TODO 코드를 개선해야함.
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < fields.length; ++i) {
            Field field = fields[i];
            field.setAccessible(true);
            if (field.isSynthetic()) {
                continue;
            }
            if (isInValidModifiers(field)) {
                continue;
            }
            stringBuilder.append(convertStringFormat(field.getName()));
            stringBuilder.append(":");
            Class<?> fieldType = field.getType();
            if (fieldType.isPrimitive()) {
                stringBuilder.append(convertStringFormat(field.get(object)));
            }
            else if (fieldType.equals(String.class)) {
                stringBuilder.append(convertStringFormat(field.get(object)));
            }
            else if (fieldType.isArray()) {
                Object o = field.get(object);
                int length = Array.getLength(o);
                stringBuilder.append("[");
                for (int k = 0; k < length; ++k) {
                    stringBuilder.append(convertStringFormat(Array.get(o, k)));
                    if (k != length - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("]");
            } else {
                String s = writeToString(field.get(object));
                stringBuilder.append(s);
            }
            if (i != fields.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private static String convertStringFormat(Object object) {
        if (object instanceof String) {
            return String.format("\"%s\"", object);
        }
        return object.toString();
    }

    private static boolean isInValidModifiers(Field field) {
        int modifiers = field.getModifiers();
        return Modifier.isTransient(modifiers) || Modifier.isNative(modifiers) || Modifier.isStatic(modifiers);
    }

}
