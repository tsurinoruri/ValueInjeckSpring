injecting values from application properies/PropertySource/ for dev, test, prod

task.name=MainTask
task.duration=60
task.tags=important,backend,week1

task.priorities.high=10
task.priorities.medium=5
task.priorities.low=1

@ConfigurationProperties(prefix = "task")
public class TaskProperties {

  private String name;
  private int duration;
  private List<String> tags;
  private Map<String, Integer> priorities;
