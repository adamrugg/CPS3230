package aspects;

import larva.*;
public aspect _asp_alertLimit0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_alertLimit0.initialize();
}
}
before () : (call(* *.alertView(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alertLimit0.lock){

_cls_alertLimit0 _cls_inst = _cls_alertLimit0._get_cls_alertLimit0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 28/*alertView*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 28/*alertView*/);
}
}
before () : (call(* *.invalidAlertView(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alertLimit0.lock){

_cls_alertLimit0 _cls_inst = _cls_alertLimit0._get_cls_alertLimit0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 30/*invalidAlertView*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 30/*invalidAlertView*/);
}
}
}