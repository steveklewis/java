import javax.script.*;
import java.io.*;

public class ExecuteScript {

  public  static void main(String[] args) throws Throwable {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    engine.eval(new FileReader("helloworld.js"));
  }
}
