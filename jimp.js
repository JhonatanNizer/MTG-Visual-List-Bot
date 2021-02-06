const jimp = require('jimp')
const scryfall = require("scryfall-client")

async function getScryfallImage() {
    const card = scryfall
    .get("cards/named", {
      exact: "windfall",
    })
    .then(function (card) {
      const img = card.getImage()
      return img // set an img tag's src to this
      
    }).catch (err => {
        console.log('Erro ao ler imagem do scryfall: ' + err)
    })
}

async function main() {
    let fonte = await jimp.loadFont(jimp.FONT_SANS_32_BLACK)
    let mask = await jimp.read('images/mascara.jpg')
    let fundo = await jimp.read('images/fundo.jpg')

    jimp.read('https://cdn.jornaldebrasilia.com.br/wp-content/uploads/2020/09/20191004154953157610i.jpg')
    .then(avatar => {
        avatar.resize(50, 50)
        mask.resize(130, 130)
        avatar.mask(mask)
        fundo.print(fonte, 170, 175, 'Test')
        fundo.composite(avatar,40, 90).write('images/beta.png')
    })
    .catch(err => {
        console.log('Erro ao carregar a imagem: ' + err)
    });

}

getScryfallImage()
main()
