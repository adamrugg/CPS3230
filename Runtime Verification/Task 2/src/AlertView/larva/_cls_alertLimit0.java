package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_alertLimit0 implements _callable{

public static PrintWriter pw; 
public static _cls_alertLimit0 root;

public static LinkedHashMap<_cls_alertLimit0,_cls_alertLimit0> _cls_alertLimit0_instances = new LinkedHashMap<_cls_alertLimit0,_cls_alertLimit0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\adamr\\workspace\\Task 2/src/AlertView/output_alertLimit.txt");

root = new _cls_alertLimit0();
_cls_alertLimit0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_alertLimit0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public boolean loggedIn =false ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_alertLimit0() {
}

public void initialisation() {
}

public static _cls_alertLimit0 _get_cls_alertLimit0_inst() { synchronized(_cls_alertLimit0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_alertLimit0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_alertLimit0_instances){
_performLogic_alertViewProperties(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_alertLimit0[] a = new _cls_alertLimit0[1];
synchronized(_cls_alertLimit0_instances){
a = _cls_alertLimit0_instances.keySet().toArray(a);}
for (_cls_alertLimit0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_alertLimit0_instances){
_cls_alertLimit0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_alertViewProperties = 13;

public void _performLogic_alertViewProperties(String _info, int... _event) {

_cls_alertLimit0.pw.println("[alertViewProperties]AUTOMATON::> alertViewProperties("+") STATE::>"+ _string_alertViewProperties(_state_id_alertViewProperties, 0));
_cls_alertLimit0.pw.flush();

if (0==1){}
else if (_state_id_alertViewProperties==13){
		if (1==0){}
		else if ((_occurredEvent(_event,28/*alertView*/))){
		_cls_alertLimit0.pw .println ("Valid alert view");

		_state_id_alertViewProperties = 12;//moving to state viewAlerts
		_goto_alertViewProperties(_info);
		}
		else if ((_occurredEvent(_event,30/*invalidAlertView*/))){
		;
_cls_alertLimit0.pw .println ("Invalid alert view");

		_state_id_alertViewProperties = 11;//moving to state badState
		_goto_alertViewProperties(_info);
		}
}
}

public void _goto_alertViewProperties(String _info){
_cls_alertLimit0.pw.println("[alertViewProperties]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_alertViewProperties(_state_id_alertViewProperties, 1));
_cls_alertLimit0.pw.flush();
}

public String _string_alertViewProperties(int _state_id, int _mode){
switch(_state_id){
case 11: if (_mode == 0) return "badState"; else return "!!!SYSTEM REACHED BAD STATE!!! badState "+new _BadStateExceptionalertLimit().toString()+" ";
case 13: if (_mode == 0) return "loggedIn"; else return "loggedIn";
case 12: if (_mode == 0) return "viewAlerts"; else return "viewAlerts";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}