package filter;

import entity.Question;
import entity.Stage;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class GameFilter implements Filter {
    HashMap<Integer, Question> hashMapCore = new HashMap<>();
    HashMap<Integer, Question> hashMapCollection = new HashMap<>();
    HashMap<Integer, Question> hashMapException = new HashMap<>();
    HashMap<Integer, Question> hashMapFlow = new HashMap<>();
    int store = 0;
    int life = 3;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        questionCore(hashMapCore);
        questionCollection(hashMapCollection);
        questionException(hashMapException);
        questionFlow(hashMapFlow);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        User user = null;
        String stage = null;

        Cookie cookieFromClient = null;
        Cookie[] arrayCookie = req.getCookies();
        if(arrayCookie != null){
            for (int i = 0; i < arrayCookie.length; i++) {
                if(arrayCookie[i].getName().equals("stage")){
                    cookieFromClient = arrayCookie[i];
                }
            }
        }

        if(cookieFromClient != null){
            stage = cookieFromClient.getValue().toString();
        }

        if(session.isNew()){
            String address = req.getRemoteAddr();
            req.setAttribute("address",address);
            req.setAttribute("score",Integer.toString(store));
            req.setAttribute("life",Integer.toString(life));
            req.setAttribute("name","No name");
             user = new User();
            Cookie cookie = new Cookie("stage",Stage.CORE.toString());
            res.addCookie(cookie);
             req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, res);
        }else{
            if (stage.equals(Stage.CORE.toString())) {
                Random random = new Random();
                int questionNumber = random.nextInt(4);
                Question question = hashMapCore.get(questionNumber);

                if(req.getParameter("answer") != null){
                    String questionNumberFromClien = req.getParameter("questionNumber");
                    String answerForQuestion = hashMapCore.get(Integer.parseInt(questionNumberFromClien)).getAnswer();
                    String answer = req.getParameter("answer");
                    if(answer.equals(answerForQuestion)){
                        store+=10;
                    }else{
                        life-=1;
                        if(life <= 0){
                            Cookie cookie = new Cookie("stage",Stage.END.toString());
                            res.addCookie(cookie);
                            life = 3;
                            store = 0;
                        }
                    }
                }
                ArrayList<String> arrayList = question.getArrayAnswer();
                Collections.shuffle(arrayList);
                req.setAttribute("question",question.getQuestion());
                req.setAttribute("questionNumber", Integer.toString(questionNumber));
                req.setAttribute("answer1", arrayList.get(0));
                req.setAttribute("answer2", arrayList.get(1));
                req.setAttribute("answer3", arrayList.get(2));
                req.setAttribute("answer4", arrayList.get(3));
                String address = req.getRemoteAddr();
                String name = req.getParameter("name");
                Cookie cookieUser = new Cookie("user",name);
                res.addCookie(cookieUser);
                req.setAttribute("address",address);
                req.setAttribute("score",Integer.toString(store));
                req.setAttribute("life",Integer.toString(life));
                req.setAttribute("name",name);
                req.getRequestDispatcher("/WEB-INF/game.jsp").forward(req, res);

            }else if (stage.equals(Stage.COLLECTION.toString())) {
                Random random = new Random();
                int questionNumber = random.nextInt(4);
                Question question = hashMapCollection.get(questionNumber);
                if(req.getParameter("answer") != null){
                    String questionNumberFromClien = req.getParameter("questionNumber");
                    String answerForQuestion = hashMapCollection.get(Integer.parseInt(questionNumberFromClien)).getAnswer();
                    String answer = req.getParameter("answer");
                    if(answer.equals(answerForQuestion)){
                        store+=10;
                    }else{
                        life-=1;
                        if(life <= 0){
                            Cookie cookie = new Cookie("stage",Stage.END.toString());
                            res.addCookie(cookie);
                            life = 3;
                            store = 0;
                        }
                    }
                }
                ArrayList<String> arrayList = question.getArrayAnswer();
                Collections.shuffle(arrayList);
                req.setAttribute("question",question.getQuestion());
                req.setAttribute("questionNumber", Integer.toString(questionNumber));
                req.setAttribute("answer1", arrayList.get(0));
                req.setAttribute("answer2", arrayList.get(1));
                req.setAttribute("answer3", arrayList.get(2));
                req.setAttribute("answer4", arrayList.get(3));
                String address = req.getRemoteAddr();
                String name = req.getParameter("name");
                Cookie cookieUser = new Cookie("user",name);
                res.addCookie(cookieUser);
                req.setAttribute("address",address);
                req.setAttribute("score",Integer.toString(store));
                req.setAttribute("life",Integer.toString(life));
                req.setAttribute("name",name);
                req.getRequestDispatcher("/WEB-INF/game.jsp").forward(req, res);
            }else if (stage.equals(Stage.EXCEPTION.toString())) {
                Random random = new Random();
                int questionNumber = random.nextInt(4);
                Question question = hashMapException.get(questionNumber);
                if(req.getParameter("answer") != null){
                    String questionNumberFromClien = req.getParameter("questionNumber");
                    String answerForQuestion = hashMapException.get(Integer.parseInt(questionNumberFromClien)).getAnswer();
                    String answer = req.getParameter("answer");
                    if(answer.equals(answerForQuestion)){
                        store+=10;
                    }else{
                        life-=1;
                        if(life <= 0){
                            Cookie cookie = new Cookie("stage",Stage.END.toString());
                            res.addCookie(cookie);
                            life = 3;
                            store = 0;
                        }
                    }
                }
                ArrayList<String> arrayList = question.getArrayAnswer();
                Collections.shuffle(arrayList);
                req.setAttribute("question",question.getQuestion());
                req.setAttribute("questionNumber", Integer.toString(questionNumber));
                req.setAttribute("answer1", arrayList.get(0));
                req.setAttribute("answer2", arrayList.get(1));
                req.setAttribute("answer3", arrayList.get(2));
                req.setAttribute("answer4", arrayList.get(3));
                String address = req.getRemoteAddr();
                String name = req.getParameter("name");
                Cookie cookieUser = new Cookie("user",name);
                res.addCookie(cookieUser);
                req.setAttribute("address",address);
                req.setAttribute("score",Integer.toString(store));
                req.setAttribute("life",Integer.toString(life));
                req.setAttribute("name",name);
                req.getRequestDispatcher("/WEB-INF/game.jsp").forward(req, res);
            }else if (stage.equals(Stage.FLOW.toString())) {
                Random random = new Random();
                int questionNumber = random.nextInt(4);
                Question question = hashMapFlow.get(questionNumber);
                if(req.getParameter("answer") != null){
                    String questionNumberFromClien = req.getParameter("questionNumber");
                    String answerForQuestion = hashMapFlow.get(Integer.parseInt(questionNumberFromClien)).getAnswer();
                    String answer = req.getParameter("answer");
                    System.out.println("answer for question: " +question.getAnswer());
                    if(answer.equals(answerForQuestion)){
                        store+=10;
                    }else{
                        life-=1;
                        if(life <= 0){
                            Cookie cookie = new Cookie("stage",Stage.END.toString());
                            res.addCookie(cookie);
                            life = 3;
                            store = 0;
                        }
                    }
                }
                ArrayList<String> arrayList = question.getArrayAnswer();
                Collections.shuffle(arrayList);
                req.setAttribute("question",question.getQuestion());
                req.setAttribute("questionNumber", Integer.toString(questionNumber));
                req.setAttribute("answer1", arrayList.get(0));
                req.setAttribute("answer2", arrayList.get(1));
                req.setAttribute("answer3", arrayList.get(2));
                req.setAttribute("answer4", arrayList.get(3));
                String address = req.getRemoteAddr();
                String name = req.getParameter("name");
                Cookie cookieUser = new Cookie("user",name);
                res.addCookie(cookieUser);
                req.setAttribute("address",address);
                req.setAttribute("score",Integer.toString(store));
                req.setAttribute("life",Integer.toString(life));
                req.setAttribute("name",name);
                req.getRequestDispatcher("/WEB-INF/game.jsp").forward(req, res);
            }else if (stage.equals(Stage.END.toString())) {
                String address = req.getRemoteAddr();
                String name = req.getParameter("name");
                req.setAttribute("address",address);
                req.setAttribute("score",Integer.toString(store));
                req.setAttribute("name",name);
                req.getRequestDispatcher("/WEB-INF/end.jsp").forward(req, res);
            }
        }
    }

    @Override
    public void destroy() {

    }


    public void questionCore(HashMap hashMap){
        Question question = new Question("Какие существуют модификаторы доступа?","private, default, protected, public");
        ArrayList<String> arrayList = question.getArrayAnswer();
        arrayList.add(question.getAnswer());
        arrayList.add("private, void, protected, public");
        arrayList.add("private, void, static, public");
        arrayList.add("private, default, static, public");
        hashMap.put(0,question);

        Question question2 = new Question("Что вы знаете о функции main()?","Метод main() — точка входа в программу.");
        arrayList = question2.getArrayAnswer();
        arrayList.add(question2.getAnswer());
        arrayList.add("Метод main() — это метод класса Main.");
        arrayList.add("Метод main() — это метод который хранит все переменные.");
        arrayList.add("Метод main() — точка в которой инициализируются переменные");
        hashMap.put(1,question2);

        Question question3 = new Question("Какими значениями инициализируются переменные по умолчанию?","числа = 0, символы = u0000, boolean = false, Объекты = null");
        arrayList = question3.getArrayAnswer();
        arrayList.add(question3.getAnswer());
        arrayList.add("всем значениям присваивается null");
        arrayList.add("числа = 1, строкам и символам, boolean = null");
        arrayList.add("всем значениям присваивается undefine");
        hashMap.put(2,question3);

        Question question4 = new Question("Что такое «статический класс»?","Это вложенный класс, объявленный с использованием ключевого слова static.");
        arrayList = question4.getArrayAnswer();
        arrayList.add(question4.getAnswer());
        arrayList.add("Это класс, объявленный с использованием ключевого слова static.");
        arrayList.add("Это класс, который использует статические переменные.");
        arrayList.add("Это класс, который наследуется от стачиского интерфейса.");
        hashMap.put(3,question4);

    }

    public void questionCollection(HashMap hashMap){
        Question question = new Question("Что такое «коллекция»?","«Коллекция» - это структура данных, набор каких-либо объектов.");
        ArrayList<String> arrayList = question.getArrayAnswer();
        arrayList.add(question.getAnswer());
        arrayList.add("«Коллекция» - это набор каких-либо объектов.");
        arrayList.add("«Коллекция» - содержит операции над объектом");
        arrayList.add("«Коллекция» - это структура данных.");
        hashMap.put(0,question);

        Question question2 = new Question("Почему Map — это не Collection, в то время как List и Set являются Collection?","Collection представляет собой совокупность некоторых элементов. Map - это совокупность пар «ключ-значение».");
        arrayList = question2.getArrayAnswer();
        arrayList.add(question2.getAnswer());
        arrayList.add("Collection представляет собой совокупность коллекций. Map - это совокупность карт.");
        arrayList.add("Collection представляет собой связный список. Map - это совокупность пар «ключ-значение».");
        arrayList.add("Collection представляет собой совокупность некоторых элементов. Map - это совокупность пар «значение-ключ».");
        hashMap.put(1,question2);

        Question question3 = new Question("Как между собой связаны Iterable и Iterator?","Интерфейс Iterable имеет только один метод - iterator(), который возвращает Iterator.");
        arrayList = question3.getArrayAnswer();
        arrayList.add(question3.getAnswer());
        arrayList.add("Интерфейс iterator имеет только один метод - Iterable(), который возвращает Iterator.");
        arrayList.add("чИнтерфейс iterator делает то же самое, что и Iterator.");
        arrayList.add("Они возвращают объект как массив.");
        hashMap.put(2,question3);

        Question question4 = new Question("Какая коллекция реализует FIFO?","Queue");
        arrayList = question4.getArrayAnswer();
        arrayList.add(question4.getAnswer());
        arrayList.add("HashMap");
        arrayList.add("Stack");
        arrayList.add("ArrayList");
        hashMap.put(3,question4);
    }

    public void questionException(HashMap hashMap){
        Question question = new Question("Какой оператор позволяет принудительно выбросить исключение?","throw new Exception();");
        ArrayList<String> arrayList = question.getArrayAnswer();
        arrayList.add(question.getAnswer());
        arrayList.add("throws new Exception();");
        arrayList.add("new Exception();");
        arrayList.add("new Exception throw;");
        hashMap.put(0,question);

        Question question2 = new Question("Что такое исключение в Java?","Исключение-это событие ошибки, которое может произойти во время выполнения программы и нарушить ее нормальный поток.");
        arrayList = question2.getArrayAnswer();
        arrayList.add(question2.getAnswer());
        arrayList.add("Исключение-это специальный класс");
        arrayList.add("Исключение-это для сохранения ошибка");
        arrayList.add("Исключение-это класс в котором хранятся ошибки при выполнении программы");
        hashMap.put(1,question2);

        Question question3 = new Question("С какого класса начинается иерархия исключений","Throwable");
        arrayList = question3.getArrayAnswer();
        arrayList.add(question3.getAnswer());
        arrayList.add("Errors");
        arrayList.add("Exceptions");
        arrayList.add("RuntimeException");
        hashMap.put(2,question3);

        Question question4 = new Question("О чем говорит ключевое слово throws?","throws — обозначает, что метод потенциально может выбросить исключение с указанным типом исключения.");
        arrayList = question4.getArrayAnswer();
        arrayList.add(question4.getAnswer());
        arrayList.add("throws — обозначает, что метод будет обрабатывать исключения.");
        arrayList.add("throws — принимает ключение");
        arrayList.add("throws — принимает или выкидывает исключение.");
        hashMap.put(3,question4);
    }

    public void questionFlow(HashMap hashMap){
        Question question = new Question("Для чего используется ключевое слово volatile?","volatile - этот модификатор вынуждает потоки отключить оптимизацию доступа и использовать единственный экземпляр переменной.");
        ArrayList<String> arrayList = question.getArrayAnswer();
        arrayList.add(question.getAnswer());
        arrayList.add("volatile - этот метод вынуждает потоки отключить оптимизацию доступа и использовать единственный экземпляр переменной.");
        arrayList.add("volatile - этот метод вынуждает использовать копию экземпляра переменной.");
        arrayList.add("volatile - переменная для многопоточной работы.");
        hashMap.put(0,question);

        Question question2 = new Question("Что такое «потоки-демоны»?","Потоки-демоны работают в фоновом режиме вместе с программой, но не являются неотъемлемой частью программы.");
        arrayList = question2.getArrayAnswer();
        arrayList.add(question2.getAnswer());
        arrayList.add("Потоки-демоны это когда программы работают не так как надо.");
        arrayList.add("Потоки-демоны это когда поток повис и съедает память.");
        arrayList.add("Потоки-демоны работают в фоновом режиме, вирусная программа.");
        hashMap.put(1,question2);

        Question question3 = new Question("Какой параметр запуска JVM используется для контроля размера стека потока?","-Xss");
        arrayList = question3.getArrayAnswer();
        arrayList.add(question3.getAnswer());
        arrayList.add("-XsM");
        arrayList.add("-Xms");
        arrayList.add("-Xmm");
        hashMap.put(2,question3);

        Question question4 = new Question("Что делает метод wait()","освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор, пока другой поток не вызовет метод notify()");
        arrayList = question4.getArrayAnswer();
        arrayList.add(question4.getAnswer());
        arrayList.add("Остальные потоки будут ждать замерщения потока, который вызвал метод wait().");
        arrayList.add("Поток будет прекращен.");
        arrayList.add("Поток будет ждать замеошения метода main().");
        hashMap.put(3,question4);
    }
}
