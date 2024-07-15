import { createRouter, createWebHistory } from 'vue-router'

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
    }
  ]})

export default router
