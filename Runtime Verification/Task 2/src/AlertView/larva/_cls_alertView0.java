package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_alertView0 implements _callable{

public static PrintWriter pw; 
public static _cls_alertView0 root;

public static LinkedHashMap<_cls_alertView0,_cls_alertView0> _cls_alertView0_instances = new LinkedHashMap<_cls_alertView0,_cls_alertView0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\adamr\\workspace\\Task 2/src/AlertView/output_alertView.txt");

root = new _cls_alertView0();
_cls_alertView0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_alertView0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public boolean loggedIn =false ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_alertView0() {
}

public void initialisation() {
}

public static _cls_alertView0 _get_cls_alertView0_inst() { synchronized(_cls_alertView0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_alertView0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_alertView0_instances){
_performLogic_badLoginsProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_alertView0[] a = new _cls_alertView0[1];
synchronized(_cls_alertView0_instances){
a = _cls_alertView0_instances.keySet().toArray(a);}
for (_cls_alertView0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_alertView0_instances){
_cls_alertView0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_badLoginsProperty = 21;

public void _performLogic_badLoginsProperty(String _info, int... _event) {

_cls_alertView0.pw.println("[badLoginsProperty]AUTOMATON::> badLoginsProperty("+") STATE::>"+ _string_badLoginsProperty(_state_id_badLoginsProperty, 0));
_cls_alertView0.pw.flush();

if (0==1){}
else if (_state_id_badLoginsProperty==20){
		if (1==0){}
		else if ((_occurredEvent(_event,48/*logOut*/))){
		loggedIn =true ;
_cls_alertView0.pw .println ("Valid logout");

		_state_id_badLoginsProperty = 21;//moving to state loggedOut
		_goto_badLoginsProperty(_info);
		}
}
else if (_state_id_badLoginsProperty==21){
		if (1==0){}
		else if ((_occurredEvent(_event,52/*invalidLogin*/))){
		loggedIn =false ;
_cls_alertView0.pw .println ("Invalid login");

		_state_id_badLoginsProperty = 21;//moving to state loggedOut
		_goto_badLoginsProperty(_info);
		}
		else if ((_occurredEvent(_event,50/*validLogin*/))){
		loggedIn =true ;
_cls_alertView0.pw .println ("Valid login");

		_state_id_badLoginsProperty = 20;//moving to state loggedIn
		_goto_badLoginsProperty(_info);
		}
}
}

public void _goto_badLoginsProperty(String _info){
_cls_alertView0.pw.println("[badLoginsProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_badLoginsProperty(_state_id_badLoginsProperty, 1));
_cls_alertView0.pw.flush();
}

public String _string_badLoginsProperty(int _state_id, int _mode){
switch(_state_id){
case 20: if (_mode == 0) return "loggedIn"; else return "loggedIn";
case 21: if (_mode == 0) return "loggedOut"; else return "loggedOut";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}