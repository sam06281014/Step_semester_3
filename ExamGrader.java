import java.util.*;

abstract class Question {
    protected String correct;
    protected String student;
    protected int points;

    Question(String correct, String student, int points) {
        this.correct = correct;
        this.student = student;
        this.points = points;
    }

    abstract String getType();

    abstract double score();
}

class McqQuestion extends Question {
    McqQuestion(String correct, String student, int points) {
        super(correct, student, points);
    }

    String getType() {
        return "MCQ";
    }

    double score() {
        return student.equals(correct) ? points : 0;
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String correct, String student, int points) {
        super(correct, student, points);
    }

    String getType() {
        return "TF";
    }

    double score() {
        return student.equals(correct) ? points : 0;
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String correct, String student, int points) {
        super(correct, student, points);
    }

    String getType() {
        return "ESSAY";
    }

    double score() {
        String answer = student.toLowerCase();
        int matched = 0;
        for (String k : correct.split(",")) {
            String key = k.trim().toLowerCase();
            if (!key.isEmpty() && answer.contains(key)) {
                matched++;
            }
        }
        if (matched >= 2) {
            return points * 0.75;
        }
        if (matched == 1) {
            return points * 0.50;
        }
        return 0;
    }
}

public class ExamGrader {
    static List<String> tokens(String line) {
        List<String> r = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean quoted = false;
        for (char c : line.toCharArray()) {
            if (c == '"') {
                quoted = !quoted;
            } else if (c == ' ' && !quoted) {
                if (sb.length() > 0) {
                    r.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            r.add(sb.toString());
        }
        return r;
    }

    static Question create(String type, String correct,
                           String student, int points) {
        switch (type.toUpperCase()) {
            case "MCQ":
                return new McqQuestion(correct, student, points);
            case "TF":
                return new TrueFalseQuestion(correct, student, points);
            default:
                return new EssayQuestion(correct, student, points);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> t = tokens(sc.nextLine().trim());
            int points = Integer.parseInt(t.get(4));
            list.add(create(t.get(0), t.get(2), t.get(3), points));
        }
        double total = 0;
        for (Question q : list) {
            double s = q.score();
            total += s;
            String out = String.format(Locale.US, "%.2f", s);
            System.out.println(q.getType() + ": " + out);
        }
        String out = String.format(Locale.US, "%.2f", total);
        System.out.println("Total Score: " + out);
        sc.close();
    }
}
