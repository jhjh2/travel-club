package io.myweb.travelclub.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NameValue {

    private String name;
    private String value;

    @Override
    public String toString() {
        //
        StringBuilder builder = new StringBuilder();

        builder.append("NameValue{")
                .append("name='").append(name).append('\'')
                .append(", value='").append(value).append('\'')
                .append('}');

        return builder.toString();
    }
}