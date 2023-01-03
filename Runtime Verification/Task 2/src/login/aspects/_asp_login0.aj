package aspects;

import larva.*;
public aspect _asp_login0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_login0.initialize();
}
}
before () : (call(* *.validLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_login0.lock){

_cls_login0 _cls_inst = _cls_login0._get_cls_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 2/*validLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 2/*validLogin*/);
}
}
before () : (call(* *.invalidLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_login0.lock){

_cls_login0 _cls_inst = _cls_login0._get_cls_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 4/*invalidLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 4/*invalidLogin*/);
}
}
before () : (call(* *.logOut(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_login0.lock){

_cls_login0 _cls_inst = _cls_login0._get_cls_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 0/*logOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 0/*logOut*/);
}
}
}