async function loadMessages(){
 const id=new URLSearchParams(location.search).get('conversationId');if(!id)return;
 const m=await api('api/messages?conversationId='+id);
 document.getElementById('messages').innerHTML=m.map(x=>`<div><b>@${esc(x.sender.username)}</b>: ${esc(x.messageText)}</div>`).join('');
}
async function sendMessage(){const id=new URLSearchParams(location.search).get('conversationId');const text=document.getElementById('text').value;if(!text)return;await api('api/messages',{method:'POST',body:enc({conversationId:id,text})});document.getElementById('text').value='';loadMessages();}
document.addEventListener('DOMContentLoaded',loadMessages);
