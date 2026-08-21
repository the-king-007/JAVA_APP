import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Candidate {
    int candidateId;
    String name;
    int aptitude;
    int technical;
    int communication;

    public Candidate(int candidateId, String name, int aptitude, int technical, int communication) {
        this.candidateId = candidateId;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }

    public int getTotalScore() {
        return aptitude + technical + communication;
    }
}

public class CandidateSelection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNext()) return;

        // Read N and K
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine(); // Clear the buffer newline

        Candidate[] candidates = new Candidate[N];

        for (int i = 0; i < N; i++) {
            if (!sc.hasNextLine()) break;
            
            String line = sc.nextLine().trim();
            while (line.isEmpty() && sc.hasNextLine()) {
                line = sc.nextLine().trim();
            }

            // Split by one or more whitespace spaces
            String[] parts = line.split("\\s+");

            int id = Integer.parseInt(parts[0]);
            
            // Reconstruct name in case it has spaces
            StringBuilder nameBuilder = new StringBuilder();
            for (int j = 1; j < parts.length - 3; j++) {
                nameBuilder.append(parts[j]).append(j == parts.length - 4 ? "" : " ");
            }
            String name = nameBuilder.toString();

            int aptitude = Integer.parseInt(parts[parts.length - 3]);
            int technical = Integer.parseInt(parts[parts.length - 2]);
            int communication = Integer.parseInt(parts[parts.length - 1]);

            candidates[i] = new Candidate(id, name, aptitude, technical, communication);
        }

        // Custom Sort: Higher total score first. If tied, smaller candidate ID first.
        Arrays.sort(candidates, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate c1, Candidate c2) {
                int score1 = c1.getTotalScore();
                int score2 = c2.getTotalScore();

                if (score1 != score2) {
                    return Integer.compare(score2, score1); // Descending order of score
                }
                return Integer.compare(c1.candidateId, c2.candidateId); // Ascending order of ID
            }
        });

        // Display Top K candidates
        for (int i = 0; i < K && i < N; i++) {
            System.out.println(candidates[i].candidateId + " " + candidates[i].name + " " + candidates[i].getTotalScore());
        }

        sc.close();
    }
}