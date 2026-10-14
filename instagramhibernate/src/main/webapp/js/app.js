async function api(url, options={}){const r=await fetch(url,options);if(!r.ok)throw new Error((await r.text())||r.statusText);return r.json();}
function enc(data){return new URLSearchParams(data);}
function esc(s){return String(s??'').replace(/[&<>"']/g,c=>({'&':'&amp;','<':'&lt;','>':'&gt;','"':'&quot;',"'":'&#39;'}[c]));}
async function logout(){await api('api/logout',{method:'POST'});location.href='login.html';}
