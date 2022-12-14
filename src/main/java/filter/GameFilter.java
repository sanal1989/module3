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
        Question question = new Question("?????????? ???????????????????? ???????????????????????? ???????????????","private, default, protected, public");
        ArrayList<String> arrayList = question.getArrayAnswer();
        arrayList.add(question.getAnswer());
        arrayList.add("private, void, protected, public");
        arrayList.add("private, void, static, public");
        arrayList.add("private, default, static, public");
        hashMap.put(0,question);

        Question question2 = new Question("?????? ???? ???????????? ?? ?????????????? main()?","?????????? main() ??? ?????????? ?????????? ?? ??????????????????.");
        arrayList = question2.getArrayAnswer();
        arrayList.add(question2.getAnswer());
        arrayList.add("?????????? main() ??? ?????? ?????????? ???????????? Main.");
        arrayList.add("?????????? main() ??? ?????? ?????????? ?????????????? ???????????? ?????? ????????????????????.");
        arrayList.add("?????????? main() ??? ?????????? ?? ?????????????? ???????????????????????????????? ????????????????????");
        hashMap.put(1,question2);

        Question question3 = new Question("???????????? ???????????????????? ???????????????????????????????? ???????????????????? ???? ???????????????????","?????????? = 0, ?????????????? = u0000, boolean = false, ?????????????? = null");
        arrayList = question3.getArrayAnswer();
        arrayList.add(question3.getAnswer());
        arrayList.add("???????? ?????????????????? ?????????????????????????? null");
        arrayList.add("?????????? = 1, ?????????????? ?? ????????????????, boolean = null");
        arrayList.add("???????? ?????????????????? ?????????????????????????? undefine");
        hashMap.put(2,question3);

        Question question4 = new Question("?????? ?????????? ???????????????????????? ?????????????","?????? ?????????????????? ??????????, ?????????????????????? ?? ???????????????????????????? ?????????????????? ?????????? static.");
        arrayList = question4.getArrayAnswer();
        arrayList.add(question4.getAnswer());
        arrayList.add("?????? ??????????, ?????????????????????? ?? ???????????????????????????? ?????????????????? ?????????? static.");
        arrayList.add("?????? ??????????, ?????????????? ???????????????????? ?????????????????????? ????????????????????.");
        arrayList.add("?????? ??????????, ?????????????? ?????????????????????? ???? ???????????????????? ????????????????????.");
        hashMap.put(3,question4);

    }

    public void questionCollection(HashMap hashMap){
        Question question = new Question("?????? ?????????? ???????????????????????","?????????????????????? - ?????? ?????????????????? ????????????, ?????????? ??????????-???????? ????????????????.");
        ArrayList<String> arrayList = question.getArrayAnswer();
        arrayList.add(question.getAnswer());
        arrayList.add("?????????????????????? - ?????? ?????????? ??????????-???????? ????????????????.");
        arrayList.add("?????????????????????? - ???????????????? ???????????????? ?????? ????????????????");
        arrayList.add("?????????????????????? - ?????? ?????????????????? ????????????.");
        hashMap.put(0,question);

        Question question2 = new Question("???????????? Map ??? ?????? ???? Collection, ?? ???? ?????????? ?????? List ?? Set ???????????????? Collection?","Collection ???????????????????????? ?????????? ???????????????????????? ?????????????????? ??????????????????. Map - ?????? ???????????????????????? ?????? ??????????-??????????????????.");
        arrayList = question2.getArrayAnswer();
        arrayList.add(question2.getAnswer());
        arrayList.add("Collection ???????????????????????? ?????????? ???????????????????????? ??????????????????. Map - ?????? ???????????????????????? ????????.");
        arrayList.add("Collection ???????????????????????? ?????????? ?????????????? ????????????. Map - ?????? ???????????????????????? ?????? ??????????-??????????????????.");
        arrayList.add("Collection ???????????????????????? ?????????? ???????????????????????? ?????????????????? ??????????????????. Map - ?????? ???????????????????????? ?????? ??????????????????-??????????.");
        hashMap.put(1,question2);

        Question question3 = new Question("?????? ?????????? ?????????? ?????????????? Iterable ?? Iterator?","?????????????????? Iterable ?????????? ???????????? ???????? ?????????? - iterator(), ?????????????? ???????????????????? Iterator.");
        arrayList = question3.getArrayAnswer();
        arrayList.add(question3.getAnswer());
        arrayList.add("?????????????????? iterator ?????????? ???????????? ???????? ?????????? - Iterable(), ?????????????? ???????????????????? Iterator.");
        arrayList.add("???????????????????? iterator ???????????? ???? ???? ??????????, ?????? ?? Iterator.");
        arrayList.add("?????? ???????????????????? ???????????? ?????? ????????????.");
        hashMap.put(2,question3);

        Question question4 = new Question("?????????? ?????????????????? ?????????????????? FIFO?","Queue");
        arrayList = question4.getArrayAnswer();
        arrayList.add(question4.getAnswer());
        arrayList.add("HashMap");
        arrayList.add("Stack");
        arrayList.add("ArrayList");
        hashMap.put(3,question4);
    }

    public void questionException(HashMap hashMap){
        Question question = new Question("?????????? ???????????????? ?????????????????? ?????????????????????????? ?????????????????? ?????????????????????","throw new Exception();");
        ArrayList<String> arrayList = question.getArrayAnswer();
        arrayList.add(question.getAnswer());
        arrayList.add("throws new Exception();");
        arrayList.add("new Exception();");
        arrayList.add("new Exception throw;");
        hashMap.put(0,question);

        Question question2 = new Question("?????? ?????????? ???????????????????? ?? Java?","????????????????????-?????? ?????????????? ????????????, ?????????????? ?????????? ?????????????????? ???? ?????????? ???????????????????? ?????????????????? ?? ???????????????? ???? ???????????????????? ??????????.");
        arrayList = question2.getArrayAnswer();
        arrayList.add(question2.getAnswer());
        arrayList.add("????????????????????-?????? ?????????????????????? ??????????");
        arrayList.add("????????????????????-?????? ?????? ???????????????????? ????????????");
        arrayList.add("????????????????????-?????? ?????????? ?? ?????????????? ???????????????? ???????????? ?????? ???????????????????? ??????????????????");
        hashMap.put(1,question2);

        Question question3 = new Question("?? ???????????? ???????????? ???????????????????? ???????????????? ????????????????????","Throwable");
        arrayList = question3.getArrayAnswer();
        arrayList.add(question3.getAnswer());
        arrayList.add("Errors");
        arrayList.add("Exceptions");
        arrayList.add("RuntimeException");
        hashMap.put(2,question3);

        Question question4 = new Question("?? ?????? ?????????????? ???????????????? ?????????? throws?","throws ??? ????????????????????, ?????? ?????????? ???????????????????????? ?????????? ?????????????????? ???????????????????? ?? ?????????????????? ?????????? ????????????????????.");
        arrayList = question4.getArrayAnswer();
        arrayList.add(question4.getAnswer());
        arrayList.add("throws ??? ????????????????????, ?????? ?????????? ?????????? ???????????????????????? ????????????????????.");
        arrayList.add("throws ??? ?????????????????? ????????????????");
        arrayList.add("throws ??? ?????????????????? ?????? ???????????????????? ????????????????????.");
        hashMap.put(3,question4);
    }

    public void questionFlow(HashMap hashMap){
        Question question = new Question("?????? ???????? ???????????????????????? ???????????????? ?????????? volatile?","volatile - ???????? ?????????????????????? ?????????????????? ???????????? ?????????????????? ?????????????????????? ?????????????? ?? ???????????????????????? ???????????????????????? ?????????????????? ????????????????????.");
        ArrayList<String> arrayList = question.getArrayAnswer();
        arrayList.add(question.getAnswer());
        arrayList.add("volatile - ???????? ?????????? ?????????????????? ???????????? ?????????????????? ?????????????????????? ?????????????? ?? ???????????????????????? ???????????????????????? ?????????????????? ????????????????????.");
        arrayList.add("volatile - ???????? ?????????? ?????????????????? ???????????????????????? ?????????? ???????????????????? ????????????????????.");
        arrayList.add("volatile - ???????????????????? ?????? ?????????????????????????? ????????????.");
        hashMap.put(0,question);

        Question question2 = new Question("?????? ?????????? ??????????????-???????????????","????????????-???????????? ???????????????? ?? ?????????????? ???????????? ???????????? ?? ????????????????????, ???? ???? ???????????????? ???????????????????????? ???????????? ??????????????????.");
        arrayList = question2.getArrayAnswer();
        arrayList.add(question2.getAnswer());
        arrayList.add("????????????-???????????? ?????? ?????????? ?????????????????? ???????????????? ???? ?????? ?????? ????????.");
        arrayList.add("????????????-???????????? ?????? ?????????? ?????????? ?????????? ?? ?????????????? ????????????.");
        arrayList.add("????????????-???????????? ???????????????? ?? ?????????????? ????????????, ???????????????? ??????????????????.");
        hashMap.put(1,question2);

        Question question3 = new Question("?????????? ???????????????? ?????????????? JVM ???????????????????????? ?????? ???????????????? ?????????????? ?????????? ?????????????","-Xss");
        arrayList = question3.getArrayAnswer();
        arrayList.add(question3.getAnswer());
        arrayList.add("-XsM");
        arrayList.add("-Xms");
        arrayList.add("-Xmm");
        hashMap.put(2,question3);

        Question question4 = new Question("?????? ???????????? ?????????? wait()","?????????????????????? ?????????????? ?? ?????????????????? ???????????????????? ?????????? ?? ?????????????????? ???????????????? ???? ?????? ??????, ???????? ???????????? ?????????? ???? ?????????????? ?????????? notify()");
        arrayList = question4.getArrayAnswer();
        arrayList.add(question4.getAnswer());
        arrayList.add("?????????????????? ???????????? ?????????? ?????????? ???????????????????? ????????????, ?????????????? ???????????? ?????????? wait().");
        arrayList.add("?????????? ?????????? ??????????????????.");
        arrayList.add("?????????? ?????????? ?????????? ???????????????????? ???????????? main().");
        hashMap.put(3,question4);
    }
}
