do 
local ffi = require 'ffi'
ffi.cdef[[
void __stdcall sayStringA (const char* str, int interrupt) ;
void __stdcall stopSpeech (void) ;
const char* __stdcall getCurrentScreenReaderNameA (void) ;
]]
local srapi = ffi.load('ScreenReaderAPI')
function sayString (str, interrupt)
if type(interrupt)=='nil' then interrupt=true end
srapi.sayStringA(str, interrupt)
end
function getCurrentScreenReaderName ()
return ffi.string(srapi.getCurrentScreenReaderNameA())
end
end

sayString('It works !', false)
sayString('You are using ' .. getCurrentScreenReaderName(), false)

