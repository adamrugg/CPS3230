package aspects;

import larva.*;
public aspect _asp_alertView0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_alertView0.initialize();
}
}
before () : (call(* *.validLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alertView0.lock){

_cls_alertView0 _cls_inst = _cls_alertView0._get_cls_alertView0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 50/*validLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 50/*validLogin*/);
}
}
before () : (call(* *.invalidLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alertView0.lock){

_cls_alertView0 _cls_inst = _cls_alertView0._get_cls_alertView0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 52/*invalidLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 52/*invalidLogin*/);
}
}
before () : (call(* *.logOut(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alertView0.lock){

_cls_alertView0 _cls_inst = _cls_alertView0._get_cls_alertView0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 48/*logOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 48/*logOut*/);
}
}
}