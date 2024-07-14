import { createRouter, createWebHistory } from 'vue-router'

/*
 * Le router declare les composants en "lazy loading".
 * Ils ne sont pas importes avant que le composant ne soit utile a une route.
 * Le "lazy loading" revient a declarer une fonction qui importe le composant 
 * au lieu de referencer en "dur" le nom du composant importe en haut du script.
*/

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../components/stickers/ViewAllStickers.vue')
    },
    {
      path: '/create',
      name: 'sticker-create',
      component: () => import('../components/stickers/CreateSticker.vue')
    },
    {
      path:'/detail/:id',
      name:'sticker-detail',
      component: () => import('../components/stickers/stickerDetails.vue')
      /*component: stickerDetails,
      props(route){ //props with function which casts id in URL from String to Number
        return {
          id : parseInt(route.params.id)
        }
      }*/
    },
    {
      path:'/edit',
      name:'stickers-edit',
      component: () => import('../components/stickers/editStickers.vue')
    },
    {
      path:'/edit/:id',
      name: 'sticker-update',
      component: () => import ('../components/stickers/updateSticker.vue')
      /*props(route){
        return {
          id : parseInt(route.params.id)
        }
      }*/
    }
  ]})

export default router
