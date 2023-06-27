package org.example;

import lombok.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
abstract class Transport {
    protected int id = 0;
    protected int maxSpeed;
    protected String plateNumber;

    public abstract void accelerate(int speed);

    public String getHeaders() {
        Class<?> cls = this.getClass();

        List<Field> parentFields = new ArrayList<>(Arrays.asList(Transport.class.getDeclaredFields()));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parentFields.size(); i++) {
            sb.append(parentFields.get(i).getName());
            if (i < parentFields.size() - 1) {
                sb.append(",");
            }
        }

        List<Field> childFields = new ArrayList<>(Arrays.asList(cls.getDeclaredFields()));
        while (cls.getSuperclass() != null) {
            cls = cls.getSuperclass();
            if (cls != Transport.class) {
                childFields.addAll(Arrays.asList(cls.getDeclaredFields()));
            }
        }
        for (Field childField : childFields) {
            sb.append(",").append(childField.getName());
        }

        return sb.toString();
    }


    public String getFieldValues() {
        Field[] childFields = this.getClass().getDeclaredFields();
        Field[] parentFields = this.getClass().getSuperclass().getDeclaredFields();
        Field[] fields = new Field[childFields.length + parentFields.length];

        System.arraycopy(parentFields, 0, fields, 0, parentFields.length);
        System.arraycopy(childFields, 0, fields, parentFields.length, childFields.length);

        StringBuilder sb = new StringBuilder();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(this);
                sb.append(value).append(", ");
            } catch (IllegalAccessException e) {

            }
        }

        sb.setLength(sb.length() - 2);

        return sb.toString();
    }
}
