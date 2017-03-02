package meme.brownwillyengine.vulkan;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.EXTDebugReport.VK_EXT_DEBUG_REPORT_EXTENSION_NAME;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.PointerBuffer;
import org.lwjgl.vulkan.VkApplicationInfo;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkInstanceCreateInfo;

import java.nio.ByteBuffer;

public class VulkanUtils {

    private static final boolean validation = Boolean.parseBoolean(System.getProperty("vulkan.validation", "false"));

    private static ByteBuffer[] layers = {
            memUTF8("VK_LAYER_LUNARG_standard_validation"),
    };

    public static VkInstance getVulkanInstance(PointerBuffer extensions){

        // Get Vulkan API
        VkApplicationInfo appInfo = VkApplicationInfo.calloc().sType(VK_STRUCTURE_TYPE_APPLICATION_INFO)
                .pApplicationName(memUTF8("BrownWillyEngine"))
                .pEngineName(memUTF8(""))
                .apiVersion(VK_MAKE_VERSION(1, 0, 2));

        // Gather extensions
        ByteBuffer VK_EXT_DEBUG_REPORT_EXTENSION = memUTF8(VK_EXT_DEBUG_REPORT_EXTENSION_NAME);
        PointerBuffer ppEnabledExtensionNames = memAllocPointer(extensions.remaining() + 1);
        ppEnabledExtensionNames.put(extensions) // <- platform-dependent required extensions
                .put(VK_EXT_DEBUG_REPORT_EXTENSION) // <- the debug extensions
                .flip();

        // Latch for debug
        PointerBuffer ppEnabledLayerNames = memAllocPointer(layers.length);
        for (int i = 0; validation && i < layers.length; i++)
            ppEnabledLayerNames.put(layers[i]);
        ppEnabledLayerNames.flip();

        // The Vulkan struct
        VkInstanceCreateInfo pCreateInfo = VkInstanceCreateInfo.calloc()
                .sType(VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO) // <- identifies what kind of struct this is (this is useful for extending the struct type later)
                .pNext(NULL) // <- must always be NULL until any next Vulkan version tells otherwise
                .pApplicationInfo(appInfo) // <- the application info we created above
                .ppEnabledExtensionNames(ppEnabledExtensionNames) // <- and the extension names themselves
                .ppEnabledLayerNames(ppEnabledLayerNames); // <- and the layer names themselves
        PointerBuffer pInstance = memAllocPointer(1); // <- create a PointerBuffer which will hold the handle to the created VkInstance
        int err = vkCreateInstance(pCreateInfo, null, pInstance); // <- actually create the VkInstance now!
        long instance = pInstance.get(0); // <- get the VkInstance handle
        memFree(pInstance); // <- free the PointerBuffer



        return null;
    }

}
