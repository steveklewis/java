import javax.script.*;

public class HelloWorld {

  public  static void main(String[] args) throws Throwable {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    engine.eval("print('Hello World!');");
  }
}
