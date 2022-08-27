package formular.engine;

import formular.engine.function.Add;
import formular.engine.function.And;
import formular.engine.function.Apply;
import formular.engine.function.Car;
import formular.engine.function.Cdr;
import formular.engine.function.Concat;
import formular.engine.function.Cons;
import formular.engine.function.Contains;
import formular.engine.function.Divide;
import formular.engine.function.Equal;
import formular.engine.function.Eval;
import formular.engine.function.Filter;
import formular.engine.function.Format;
import formular.engine.function.GetHash;
import formular.engine.function.GreaterThan;
import formular.engine.function.GreaterOrEqual;
import formular.engine.function.Is;
import formular.engine.function.JsonParse;
import formular.engine.function.JsonPointer;
import formular.engine.function.JsonStringify;
import formular.engine.function.Length;
import formular.engine.function.LessThan;
import formular.engine.function.LessOrEqual;
import formular.engine.function.List;
import formular.engine.function.MakeHashTable;
import formular.engine.function.Map;
import formular.engine.function.Minus;
import formular.engine.function.Multiply;
import formular.engine.function.Not;
import formular.engine.function.NotEqual;
import formular.engine.function.Nth;
import formular.engine.function.Or;
import formular.engine.function.Reduce;
import formular.engine.function.Remainder;
import formular.engine.function.SetHash;

public class Default {
    public static Environment environment() {
        final Environment environment = new Environment();
        environment.put(Symbol.of("+"), new Add());
        environment.put(Symbol.of("-"), new Minus());
        environment.put(Symbol.of("*"), new Multiply());
        environment.put(Symbol.of("/"), new Divide());
        environment.put(Symbol.of("%"), new Remainder());
        environment.put(Symbol.of("<"), new LessThan());
        environment.put(Symbol.of(">"), new GreaterThan());
        environment.put(Symbol.of("<="), new LessOrEqual());
        environment.put(Symbol.of(">="), new GreaterOrEqual());
        environment.put(Symbol.of("is"), new Is());
        environment.put(Symbol.of("eq"), new Equal());
        environment.put(Symbol.of("neq"), new NotEqual());
        environment.put(Symbol.of("car"), new Car());
        environment.put(Symbol.of("cdr"), new Cdr());
        environment.put(Symbol.of("cons"), new Cons());
        environment.put(Symbol.of("length"), new Length());
        environment.put(Symbol.of("contains"), new Contains());
        environment.put(Symbol.of("list"), new List());
        environment.put(Symbol.of("map"), new Map());
        environment.put(Symbol.of("reduce"), new Reduce());
        environment.put(Symbol.of("filter"), new Filter());
        environment.put(Symbol.of("nth"), new Nth());
        environment.put(Symbol.of("eval"), new Eval(environment, null, 0));
        environment.put(Symbol.of("apply"), new Apply());
        environment.put(Symbol.of("format"), new Format());
        environment.put(Symbol.of("concat"), new Concat());
        environment.put(Symbol.of("not"), new Not());
        environment.put(Symbol.of("and"), new And());
        environment.put(Symbol.of("or"), new Or());
        environment.put(Symbol.of("json-parse"), new JsonParse());
        environment.put(Symbol.of("json-ptr"), new JsonPointer());
        environment.put(Symbol.of("json-stringify"), new JsonStringify());
        environment.put(Symbol.of("make-hash-table"), new MakeHashTable());
        environment.put(Symbol.of("gethash"), new GetHash());
        environment.put(Symbol.of("sethash"), new SetHash());
        environment.alias(Symbol.of("eq"), Symbol.of("="));
        environment.alias(Symbol.of("eq"), Symbol.of("=="));
        environment.alias(Symbol.of("eq"), Symbol.of("equal"));
        environment.alias(Symbol.of("eq"), Symbol.of("相等"));
        environment.alias(Symbol.of("neq"), Symbol.of("不相等"));
        environment.alias(Symbol.of("neq"), Symbol.of("!="));
        environment.alias(Symbol.of("neq"), Symbol.of("<>"));
        environment.alias(Symbol.of("car"), Symbol.of("head"));
        environment.alias(Symbol.of("cdr"), Symbol.of("tail"));
        environment.alias(Symbol.of("+"), Symbol.of("add"));
        environment.alias(Symbol.of("+"), Symbol.of("求和"));
        environment.alias(Symbol.of("-"), Symbol.of("minus"));
        environment.alias(Symbol.of("-"), Symbol.of("相减"));
        environment.alias(Symbol.of("*"), Symbol.of("multiply"));
        environment.alias(Symbol.of("*"), Symbol.of("乘积"));
        environment.alias(Symbol.of("/"), Symbol.of("divide"));
        environment.alias(Symbol.of("/"), Symbol.of("相除"));
        environment.alias(Symbol.of("%"), Symbol.of("mod"));
        environment.alias(Symbol.of("%"), Symbol.of("余数"));
        environment.alias(Symbol.of("<"), Symbol.of("less-than"));
        environment.alias(Symbol.of("<"), Symbol.of("小于"));
        environment.alias(Symbol.of(">"), Symbol.of("greater-than"));
        environment.alias(Symbol.of(">"), Symbol.of("大于"));
        environment.alias(Symbol.of("<="), Symbol.of("less-or-equal"));
        environment.alias(Symbol.of("<="), Symbol.of("小于或等于"));
        environment.alias(Symbol.of("<="), Symbol.of("no-greater-than"));
        environment.alias(Symbol.of("<="), Symbol.of("不大于"));
        environment.alias(Symbol.of(">="), Symbol.of("greater-or-equal"));
        environment.alias(Symbol.of(">="), Symbol.of("大于或等于"));
        environment.alias(Symbol.of(">="), Symbol.of("no-less-than"));
        environment.alias(Symbol.of(">="), Symbol.of("不小于"));
        return environment;
    }
}
