package primeiros_passos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

@Component
public class JsonConverter {
    @Autowired
    private Gson gson;
    public ViaCepResponse converter(String json) {
        return gson.fromJson(json, ViaCepResponse.class);
    }
}
