:- include("KB.pl").

agentState(F,M,E,s0):-
		food(F), materials(M), energy(E).

agentState(F,M,E,result(A,S)):-
		(agentState(F2,M,E,S),A=reqf,F is F2+1);
		(agentState(F,M2,E,S),A=reqm,M is M2+1);
		(agentState(F,M,E2,S),A=reqe,E is E2+1);
		(agentState(F2, M2, E2, S),A=b1 ,build1(FReq, MReq, EReq), F2 >= FReq, M2 >= MReq, E2 >= EReq, F is F2 - FReq, M is M2 - MReq, E is E2 - EReq);
		(agentState(F2, M2, E2, S),A=b2 ,build2(FReq, MReq, EReq), F2 >= FReq, M2 >= MReq, E2 >= EReq, F is F2 - FReq, M is M2 - MReq, E is E2 - EReq).
		
		
goal(S):-
        ids(S,1),
    	action_occurred(b1, S),
   		action_occurred(b2, S).

goal2(S):-
    agentState(_, _, _, S).

action_occurred(Action, result(Action, _)).
action_occurred(Action, result(_, State)) :- action_occurred(Action, State).

ids(S,L):-
	(call_with_depth_limit(goal2(S),L,R), number(R));
	(call_with_depth_limit(goal2(S),L,R), R=depth_limit_exceeded,
													L1 is L+1, ids(S,L1)).