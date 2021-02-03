const Discord = require("discord.js")
const client = new Discord.Client()
const config = require("./config.json")
const jimp = require('jimp')

const regex = /(([0-9]+)(\s)(\D+)(\(\w+\))(\s)(\d+))/gm


function sendText() {
  return "Here is your list!"
}

function sendFile() {
  return 
}

function applyRegex(message){
  let m
  var count = 0
  while ((m = regex.exec(message)) !== null) {
    // This is necessary to avoid infinite loops with zero-width matches
    if (m.index === regex.lastIndex) {
        regex.lastIndex++
    }
    // The result can be accessed through the `m`-variable.
    m.forEach((match, groupIndex) => {
      if(groupIndex == 0){
        //console.log(`Found match, group ${groupIndex}: ${match}`)
        count = count + 1
      }
    });
  }

  return count + " detected cards!"
}



client.on("ready", () => {
  console.log("Bot is ready!")
});

client.on("message", async message => {
  if(message.author.bot) return
  if(message.channel.type === "dm") return
  if(!message.content.startsWith(config.prefix)) return
  //if(!isValidList(message.content)) return
  
  const args = message.content.slice(config.prefix.length).trim().split(/ +/g)
  const comando = args.shift().toLowerCase()
  if(comando === "visual") {
    await message.channel.send(applyRegex(message.content))
    //await message.channel.send(sendText(), {files: ["./files/background.jpg"]})
  }
  
});


client.login(config.token)