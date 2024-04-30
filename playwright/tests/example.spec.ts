import { test, expect } from '@playwright/test';

test('visitar repartir', async ({ page }) => {
  await page.goto('http://localhost:8080/');

  await page.getByRole('textbox').fill('julian');
  await page.locator('#iniciarBienvenidaButton').click()
  await page.locator('#crearGruposButton').click()

  await page.locator('#nombreGrupoNuevoInput').fill('Regalo de navidad');
  await page.locator('#miembrosGrupoNuevoInput').fill('Victor');
  await page.keyboard.press('Enter');
  await page.locator('#miembrosGrupoNuevoInput').fill('Brenda');
  await page.keyboard.press('Enter');

  await page.locator('#guardarGrupoNuevoButton').click()
  
  //await expect(page.textContent('body')).toContain('Regalo de navidad');
});
