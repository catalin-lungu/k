require "simplification.k"

module ISSUE 
  imports SIMPLIFICATION
  
  configuration <k color="red"> ((#symBool(0) andBool #symBool(1)) impliesBool #symBool(3))
andBool 
(notBool(#symBool(0) andBool #symBool(1)) impliesBool #symBool(3))
 </k>

endmodule