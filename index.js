const Discord = require("discord.js"); 
const client = new Discord.Client(); 
const config = require("./config.json"); 
const jimp = require('jimp')

client.on("ready", () => {
  console.log(`Bot is ready!`); 
});

client.on("message", async message => {

  if(message.author.bot) return;
  if(message.channel.type === "dm") return;
  if(!message.content.startsWith(config.prefix)) return;

  const args = message.content.slice(config.prefix.length).trim().split(/ +/g);
  const comando = args.shift().toLowerCase();
  if(comando === "visual") {
    await message.channel.send("Here is your list!", {files: ["background.jpg"]});
  }
  
});


client.login(config.token);
//