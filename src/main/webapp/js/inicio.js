import { filter } from "./filter.js";

var fil = filter(33, 95, 69);

document.querySelectorAll(".filtered").forEach(element => element.style.filter = fil);