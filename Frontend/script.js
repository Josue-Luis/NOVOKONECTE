// js/script.js
console.log('JS funcionando!');
document.addEventListener('DOMContentLoaded', () => {
  const h = document.querySelector('h1');
  if (h) h.textContent += ' (carregado com JS)';
});