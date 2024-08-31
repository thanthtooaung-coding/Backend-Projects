import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class GitHubUserActivityCLI {

    public static void main(String[] args) {
        try {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the GitHub username: ");
            String username = inputReader.readLine();

            String apiUrl = "https://api.github.com/users/" + username + "/events";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Failed to fetch user activity. Response Code: " + responseCode);
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONArray events = new JSONArray(response.toString());
            if (events.length() == 0) {
                System.out.println("No recent activity found for user: " + username);
                return;
            }

            for (int i = 0; i < events.length(); i++) {
                JSONObject event = events.getJSONObject(i);
                String type = event.getString("type");
                JSONObject repo = event.getJSONObject("repo");
                String repoName = repo.getString("name");

                switch (type) {
                    case "PushEvent":
                        JSONArray commits = event.getJSONObject("payload").getJSONArray("commits");
                        System.out.println("Pushed " + commits.length() + " commits to " + repoName);
                        break;
                    case "IssuesEvent":
                        String action = event.getJSONObject("payload").getString("action");
                        System.out.println(action + " an issue in " + repoName);
                        break;
                    case "WatchEvent":
                        System.out.println("Starred " + repoName);
                        break;
                    default:
                        System.out.println("Performed " + type + " on " + repoName);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
