package Logic;

import Logic.Entities.Project;
import Logic.Entities.STATUS;

public interface Observer {
    void update(Project project);
}
