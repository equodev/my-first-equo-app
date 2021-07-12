package firstequoapp;

import java.util.Calendar;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.equo.comm.api.IEquoEventHandler;
import com.equo.comm.api.actions.IActionHandler;
import com.equo.comm.api.annotations.EventName;

@Component
public class MyEventHandler implements IActionHandler<String> {

    @Reference
    private IEquoEventHandler equoEventHandler;
    
    @Override
    public Object call(String payload) {
        System.out.println(payload);
        String date = Calendar.getInstance().getTime().toString();
        equoEventHandler.send("MyJSEvent",date);
        return null;
    }
    
    @EventName("exitevent")
    public void exitEvent(String payload) {
        System.out.println("Closing app...");
        System.exit(0);
    }
}