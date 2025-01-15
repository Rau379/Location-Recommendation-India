import React from 'react';
import '../style/OrdersList.css'; // Updated styling

const OrdersList = ({ orders }) => {
  if (!orders || orders.length === 0) {
    return <p>No orders available for the selected dealer.</p>; // Display message when no data is available
  }

  return (
    <div className="orders-container">
      <h2>Orders List</h2>
      <ul className="orders-list">
        {orders.map((order) => (
          <li key={order.orderId} className="order-item">
            <div className="order-card">
              <div><strong>Order ID:</strong> {order.orderId}</div>
              <div><strong>Date:</strong> {new Date(order.date).toLocaleDateString()}</div>
              <div className="items-section">
                <strong>Items:</strong>
                {order.items && order.items.length > 0 ? (
                  <ul className="items-list">
                    {order.items.map((item, index) => (
                      <li key={index} className="item">
                        <div><strong>Product:</strong> {item.product}</div>
                        <div><strong>Quantity:</strong> {item.quantity} units</div>
                        <div><strong>Status:</strong> {item.status}</div>
                      </li>
                    ))}
                  </ul>
                ) : (
                  <p>No items available for this order.</p>
                )}
              </div>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default OrdersList;
