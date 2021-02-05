const scryfall = require("scryfall-client")

const card = scryfall
.get("cards/named", {
  exact: "windfall",
})
.then(function (card) {
  const img = card.getImage();
  img; // set an img tag's src to this
});


console.log(card)